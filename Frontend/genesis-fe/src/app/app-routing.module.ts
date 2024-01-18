import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ClientesComponent} from './components/clientes/clientes.component';
import {ClientesService} from './services/clientes.service';
import {ClienteResolver} from './resolvers/cliente.resolver';
import {DetalleClienteComponent} from "./components/clientes/detalle-cliente/detalle-cliente.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/clientes',
    pathMatch: 'full'
  },
  {
    path: "clientes",
    component: ClientesComponent,
    resolve: {
      clientes: ClienteResolver
    }
  },
  {
    path: 'detalle-cliente/:id',
    component: DetalleClienteComponent
  },
  {
    path: 'detalle-cliente',
    component: DetalleClienteComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
