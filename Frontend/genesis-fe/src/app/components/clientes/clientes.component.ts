import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Cliente} from 'src/app/model/Cliente.model';
import {ClientesService} from 'src/app/services/clientes.service';
import {MatSnackBar} from "@angular/material/snack-bar";


// private Integer cantidadDeCuotas;
// @Column(name = "fecha_de_registro")
// private Date fechaDeRegistro;

const ELEMENT_DATA: Cliente[] = [
  {
    id: 1,
    dpi: '2800288490101',
    nombreCompleto: "Byron Raul Gomez Arango",
    fechaNacimiento: '11/10/2000',
    direccion: 'direccion falsa',
    telefono: '35745525',
    estadoCivil: 'S',
    fechaRegistro: new Date
  },
];

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})

export class ClientesComponent implements OnInit {

  constructor(private clienteService: ClientesService, private activatedRoute: ActivatedRoute, private snackBar: MatSnackBar) {
  }

  displayedColumns: string[] = ['id', 'nombreCompleto', 'fechaNacimiento', 'estadoCivil', 'telefono', 'acciones'];
  dataSource: [] = [];

  ngOnInit() {
    this.dataSource = this.activatedRoute.snapshot.data['clientes']
  }


  eliminarCliente(cliente: Cliente) {
    this.clienteService.deleteCliente(cliente.id).subscribe(response => {
      this.snackBar.open("Se ha eliminado el usuario: " + cliente.nombreCompleto)
      this.getClientes();
    })
    console.log(cliente)
  }


  getClientes() {
    this.clienteService.getAllClientes().subscribe(response => {
      // @ts-ignore
      this.dataSource = response;
    })
  }
}
