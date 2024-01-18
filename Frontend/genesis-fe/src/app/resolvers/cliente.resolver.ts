import { Injectable } from "@angular/core";
import { Cliente } from "../model/Cliente.model";
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { Observable } from "rxjs";
import { ClientesService } from "../services/clientes.service";

@Injectable({ providedIn: 'root' })

export class ClienteResolver implements Resolve<Cliente> {
  constructor(private clienteService: ClientesService) {}

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<Cliente> {
    return this.clienteService.getAllClientes();
  }
}
