import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ClientesService} from "../../../services/clientes.service";
import {Cliente} from "../../../model/Cliente.model";
import {Form, FormBuilder} from '@angular/forms';
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-detalle-cliente',
  templateUrl: './detalle-cliente.component.html',
  styleUrls: ['./detalle-cliente.component.css']
})
export class DetalleClienteComponent implements OnInit {
  public id: number = 0
  public cliente: Cliente;

  // public formCliente: FormBuilder;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private clienteService: ClientesService, private snackBar: MatSnackBar) {
    this.cliente = {
      id: 0,
      dpi: "",
      nombreCompleto: "",
      fechaNacimiento: "",
      direccion: "",
      telefono: "",
      estadoCivil: "",
      fechaRegistro: new Date()
    }

    // this.formCliente
  }

  ngOnInit(): void {
    this.cargarDatos();
  }


  getUserById() {
    this.clienteService.getClienteById(this.id).subscribe(response => {
      this.cliente = response;
    })
  }

  guardar() {
    this.clienteService.guardarCliente(this.cliente).subscribe(response => {
      this.snackBar.open("Cliente almacenado correctamente");
      this.router.navigate(["/", "clientes"])
    })
    console.log(this.cliente)
  }

  cargarDatos() {
    this.id = Number(this.activatedRoute.snapshot.paramMap.get("id"));
    if (this.id != 0) {
      this.getUserById()
    }
  }

}
