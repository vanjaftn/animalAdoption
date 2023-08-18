export class Vet {
    vetId: string = "";
    userId: string = "";
    // ordination: string = "";

    public constructor(obj?: any) {
        if (obj) {
            this.userId = obj.userId;
            this.vetId = obj.vetId;
            // this.ordination = obj.ordination;
        }
    }
}