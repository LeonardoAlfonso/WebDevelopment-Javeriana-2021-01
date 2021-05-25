import { Color } from "./Color";

export interface Product {
  name: string;
  description: string;
  image: string;
  id: string;
  colors: Color[];
}
