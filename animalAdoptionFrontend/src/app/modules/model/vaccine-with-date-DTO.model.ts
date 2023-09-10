export class VaccineWithDateDTO {
    vaccineId : string = "";
    vaccineType: string = "";
    animalId: string = "";
    vetId: string = "";
    vaccineDate !: Date;
    date: string = "";
    vetName: string = "";

    public constructor(obj?: any) {
        if (obj) {
            this.animalId = obj.animalId;
            this.vaccineId = obj.vaccineId;
            this.vaccineType = obj.vaccineType;
            this.vetId = obj.vetId;
            this.vaccineDate = obj.vaccineDate;
            this.date = obj.date;
            this.vetName = obj.vetName;
        }
    }
}