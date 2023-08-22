export class Video {
    videoId: string = "";
    animalId: string = "";
    videoURL: string = "";

    public constructor(obj?: any) {
        if (obj) {
            this.videoId = obj.videoId;
            this.animalId = obj.animalId;
            this.videoURL = obj.videoURL;
            
        }
    }
}