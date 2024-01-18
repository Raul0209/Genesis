import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Cliente} from '../model/Cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {
  private url: string = 'http://127.0.0.1:8080/service/v1/cliente'

  constructor(private http: HttpClient) {
  }

  getAllClientes(): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.url}/all`);
  }

  getClienteById(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.url}/${id}`);
  }

  deleteCliente(id: number): Observable<Cliente> {
    return this.http.delete<Cliente>(`${this.url}/${id}`);
  }

  guardarCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(`${this.url}`,cliente);
  }
}
