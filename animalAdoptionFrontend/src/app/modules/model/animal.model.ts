export class Animal {
    animalId : string = "";
    name: string = "";
    dateOfBirth !: Date;
    location: string = "";
    photoUrls: string = "";
    description: string = "";
    chipNumber!: number;
    size: string = "";
    animalTypeId: string = "";
    sterilized!: Boolean;

    public constructor(obj?: any) {
        if (obj) {
            this.animalId = obj.animalId;
            this.name = obj.name;
            this.dateOfBirth = obj.dateOfBirth;
            this.location = obj.location;
            this.photoUrls = obj.photoUrls;
            this.description = obj.description;
            this.chipNumber = obj.chipNumber;
            this.size = obj.size;
            this.animalTypeId = obj.animalTypeId;
            this.sterilized = obj.sterilized;
        }
    }
}