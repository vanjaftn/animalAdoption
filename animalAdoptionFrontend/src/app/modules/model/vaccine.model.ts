export class Vaccine {
    vaccineId : string = "";
    vaccineType: string = "";
    animalId: string = "";
    vetId: string = "";
    vaccineDate !: Date;

    public constructor(obj?: any) {
        if (obj) {
            this.animalId = obj.animalId;
            this.vaccineId = obj.vaccineId;
            this.vaccineType = obj.vaccineType;
            this.vetId = obj.vetId;
            this.vaccineDate = obj.vaccineDate;
        }
    }
}