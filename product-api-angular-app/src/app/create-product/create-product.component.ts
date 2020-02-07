import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';
import { ProductComponent } from '../product/product.component';


@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
    productForm:FormGroup;
  constructor(
      public productService:ProductService,
      public router:Router,
      public formBuilder: FormBuilder
  ) { 
      this.productForm = this.formBuilder.group({
          id : new FormControl("", Validators.required),
          name : new FormControl("", Validators.required),
          category : new FormControl("", Validators.required),
          retail_price : new FormControl("", Validators.required),
          discounted_price : new FormControl("", Validators.required),
          availability : new FormControl("", Validators.required) 
      });
  }

  ngOnInit() {
    }
    
    createProduct(){
        this.productService.createProduct(this.productForm.value).subscribe(data => console.log("create " +data));
        this.productService.getProducts();
        this.router.navigate(['getProducts']);
    }
}
