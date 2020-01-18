import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { CustomersComponent } from './customers/customers.component';
import { ProductsComponent } from './products/products.component';


const routes: Routes = [
{path: '', component: HomeComponent},
{path: 'customer', component: CustomersComponent},
{path: 'product', component: ProductsComponent},
{path: 'signin', component: LoginComponent},
{path: '**', component: PagenotfoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
