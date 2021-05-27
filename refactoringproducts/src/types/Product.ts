import { ProductColor } from "@/types/ProductColor";

export interface Product {
  name: string;
  description: string;
  image: string;
  id: string;
  colors: ProductColor[];
}
