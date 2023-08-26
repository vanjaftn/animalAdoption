import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { AdminService } from '../service/admin.service';
import { PhotoService } from '../service/photo.service';
import { AnimalWithPhotosDTO } from '../model/animal-with-photos-DTO.model';

@Component({
  selector: 'app-update-animal-page',
  templateUrl: './update-animal-page.component.html',
  styleUrls: ['./update-animal-page.component.css']
})
export class UpdateAnimalPageComponent {
  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')
  public selectedAnimalProfile: AnimalWithPhotosDTO = new AnimalWithPhotosDTO
  selectedFile!: File;
  selectedFiles: Array<File> = new Array()
  fileURLs : Array<string> = new Array()
  allAnimalTypes : Array<String> = new Array()
  public dob : String = ""

  constructor(private adminService: AdminService, private photoService: PhotoService, private animalService: AnimalService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'));
    this.read()
  }

  public getDate(date : Date) {
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    this.dob = day + '.' + month + '.' + year + '.'
    console.log(this.dob)
  }

  read(){
    this.animalService.read(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))
      this.selectedAnimalProfile = JSON.parse(response)

      this.getDate(new Date(this.selectedAnimalProfile.dateOfBirth))

    }
   );
  }

  update(){

  this.selectedFiles.forEach(file => {
    const formData = new FormData();

    formData.append('image', file, file.name)
  
    console.log(file) 
  
    this.photoService.uploadMedia(formData).subscribe(response=>{
      console.log(response)
      // window.location.reload()

    })
      this.fileURLs.push(file.name)

      console.log(this.fileURLs)


  });
  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!REGISTRATION
  // if(this.selectedAnimalProfile.sterilized == null){
  //   this.animal.sterilized = false
  // }

  this.selectedAnimalProfile.chipNumber = Number(this.selectedAnimalProfile.chipNumber)
  this.selectedAnimalProfile.photos = this.fileURLs

  console.log(this.fileURLs)
  console.log(this.selectedAnimalProfile)
  
  this.adminService.updateAnimal(this.selectedAnimalProfile).subscribe((response: any) => {
    console.log(response)

    alert('Successfully updated');

    // const animalId = this.selectedAnimalProfileId
    // const animalURL = `animal-profile/${animalId}`;
    // window.location.href = animalURL;  

  },(error) => {
    alert("Invalid update");
    console.log(error);
  }
 );

  }
 
  uploadPhoto(event: any) {
    const selectedFiles: FileList = event.target.files;

    console.log(selectedFiles)

    if (selectedFiles.length > 0) {
      for (let i = 0; i < selectedFiles.length; i++) {
        this.selectedFile = <File>event.target.files[i]
        console.log(this.selectedFile)
        
        this.selectedFiles.push(this.selectedFile)

      }
    }

    console.log(this.selectedFiles)
  }

}
