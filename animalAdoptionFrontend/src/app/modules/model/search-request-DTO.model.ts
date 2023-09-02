import { Animal } from "./animal.model";

export class SearchRequestDTO {
    searchInput: string = "";
    animals!: Array<Animal>;

    public constructor(obj?: any) {
        if (obj) {
            this.searchInput = obj.searchInput;
            this.animals = obj.animals;
            
        }
    }
}