import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductComponent } from './product/product.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';


const routes: Routes = [
    {path:'getProducts', component:ProductComponent},
    {path:'login', component:LoginComponent},
    {path:'', component:HeaderComponent},
    {path:'addProduct', component:CreateProductComponent},
    {path:'sign-up', component:SignUpComponent},
    {path:'updateProduct', component:UpdateProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
