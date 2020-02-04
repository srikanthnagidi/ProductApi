import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { ProductService } from '../product.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Product } from '../product/product';

@Component({
    selector: 'app-update-product',
    templateUrl: './update-product.component.html',
    styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
    products: Product[] = [];
    productForm: FormGroup;
    selectedProduct: Product = new Product();
    constructor(
        private productService: ProductService,
        private router: Router,
        private formBuilder: FormBuilder,
        private route: ActivatedRoute
    ) {
        this.productForm = this.formBuilder.group({
            retail_price: new FormControl(""),
            discounted_price: new FormControl(""),
            availability: new FormControl(Boolean)
        });
        this.productService.getProducts().subscribe(data => this.products = data);
    }

    ngOnInit() {
        //console.log(this.selectedProduct);
    }

    set onChange(value:Product){
        console.log(value);
        this.selectedProduct = value;
    }
    updateProduct() {
        console.log(this.productForm.value);
        this.productService.updateProduct(this.selectedProduct.id, this.productForm.value).subscribe(
            data => console.log(data), error => console.log(error));
        this.productService.getProducts();
        this.router.navigate(['getProducts']);
    }



}
