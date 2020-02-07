import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from './product/product';
import { ThrowStmt } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

    url = "http://localhost:8080"
  constructor(private http: HttpClient) { }

  getProducts(){
      //console.log("service");
      return this.http.get<Product[]>(this.url + "/products");
  }

  createProduct(product:Product){
    let httpHeaders = new HttpHeaders().set('Content-Type', 'application/json'); 
      return this.http.post<Product>(this.url + "/products", product, {
        headers: httpHeaders,
        observe: 'response'
      });
  }

  getProductById(id:number){
      return this.http.get<Product>(this.url + "/products/" + id);
  }

  updateProduct(id:number, product:string){
    let httpHeaders = new HttpHeaders().set('Content-Type', 'application/json'); 
    return this.http.put<Product>(this.url + "/products/" + id, product, {
      headers: httpHeaders,
      observe: 'response'
    });
  }

  deleteProductById(id:number){
    return this.http.delete<Product[]>(this.url + "/products/" + id);
  }

}
