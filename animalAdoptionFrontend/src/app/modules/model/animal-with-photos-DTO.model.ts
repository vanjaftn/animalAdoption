export class AnimalWithPhotosDTO {
    animalId : string = "";
    name: string = "";
    gender: string = "";
    dateOfBirth !: Date;
    location: string = "";
    description: string = "";
    chipNumber: string = "";
    size: string = "";
    animalType: string = "";
    sterilized!: Boolean;
    photos!: Array<string>;


    public constructor(obj?: any) {
        if (obj) {
            this.animalId = obj.animalId;
            this.name = obj.name;
            this.gender = obj.gender;
            this.dateOfBirth = obj.dateOfBirth;
            this.location = obj.location;
            this.photos = obj.photos;
            this.description = obj.description;
            this.chipNumber = obj.chipNumber;
            this.size = obj.size;
            this.animalType = obj.animalType;
            this.sterilized = obj.sterilized;
        }
    }
}