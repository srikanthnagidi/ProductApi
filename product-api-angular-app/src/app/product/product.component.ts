import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from '../product.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { DialogService } from '../dialog.service';

@Component({
    selector: 'app-product',
    templateUrl: './product.component.html',
    styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {


    products: Product[] = [];
    constructor(private productService: ProductService,
        private router: Router,
        private dialogService: DialogService) {
        this.productService.getProducts().subscribe(data => this.products = data);
    }

    ngOnInit() {
        this.productService.getProducts().subscribe(data => this.products = data);
    }

    deleteProduct(id: number) {
        this.dialogService.openConfrimDialog("Are you sure to delete this record?").afterClosed().subscribe(res =>{
            if(res){
                this.productService.deleteProductById(id).subscribe(data=>this.products=data);

            }
        });
        //this.productService.deleteProductById(id).subscribe(data => this.products = data);
    }
}