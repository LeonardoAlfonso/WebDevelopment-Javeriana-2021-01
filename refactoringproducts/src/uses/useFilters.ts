import { ref, Ref } from "vue";
import { Product } from "@/types/Product";
import { Color } from "@/types/Color";
import { ProductColor } from "@/types/ProductColor";

export function useFilters() {
  const colorSelected : Ref<string> = ref("Todos")

  function setColorSelected(colorFilter : string) {
    colorSelected.value = colorFilter
  }

  function searchByColor(products: Product[]): Product[] {
    if (colorSelected.value !== "Todos") {
      return products.filter((product) => {
        return product.colors.some(
          (productColor) => productColor.name === colorSelected.value
        );
      });
    }
    return products;
  }

  function getColorsFilters(products: Product[]): Color[] {
    const initialProductColors: ProductColor[] = [];
    const colors: Color[] = products
      .flatMap((product) => product.colors)
      .reduce((unique, productColor) => {
        if (!unique.some((item) => item.name === productColor.name)) {
          unique.push(productColor);
        }
        return unique;
      }, initialProductColors)
      .map((productColor) => {
        return {
          color: productColor.name,
          selected: false,
        };
      });

    colors.push({ color: "Todos", selected: true });
    return colors;
  }

  function modifyFilters(colors : Color[]) : Color[] {
    colors.forEach((color) => {
      color.selected = color.color === colorSelected.value;
    });
    return colors;
  }

  return {
    setColorSelected,
    searchByColor,
    getColorsFilters,
    modifyFilters
  }
}