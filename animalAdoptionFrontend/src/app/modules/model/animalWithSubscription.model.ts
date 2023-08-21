export class AnimalWithSubscription {
    animalId : string = "";
    name: string = "";
    dateOfBirth !: Date;
    location: string = "";
    description: string = "";
    chipNumber!: number;
    size: string = "";
    animalType: string = "";
    sterilized!: Boolean;
    subscription: Boolean = true;

    public constructor(obj?: any) {
        if (obj) {
            this.animalId = obj.animalId;
            this.name = obj.name;
            this.dateOfBirth = obj.dateOfBirth;
            this.location = obj.location;
            this.description = obj.description;
            this.chipNumber = obj.chipNumber;
            this.size = obj.size;
            this.animalType = obj.animalType;
            this.sterilized = obj.sterilized;
            this.subscription = obj.subscription;
        }
    }
}