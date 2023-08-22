import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { AdminService } from '../service/admin.service';
import { PhotoService } from '../service/photo.service';
import { AnimalWithPhotosDTO } from '../model/animalWithPhotosDTO.model';
import { AnimalTypeService } from '../service/animalType.service';

@Component({
  selector: 'app-register-animal',
  templateUrl: './register-animal.component.html',
  styleUrls: ['./register-animal.component.css']
})
export class RegisterAnimalComponent {
  public animal : AnimalWithPhotosDTO = new AnimalWithPhotosDTO();
  public selectedFile!: File;
  public selectedFiles: Array<File> = new Array()
  public fileURLs : Array<string> = new Array()
  public allAnimalTypes : Array<String> = new Array()
  public addAnimalTypeButton: Boolean = false
  public newType: string = ""

  constructor(private adminService: AdminService, private photoService: PhotoService, private animalService: AnimalService,
    private animalTypeService: AnimalTypeService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'));
    this.readAllAnimalTypes()
  }

  public getDate(): string {
    let date = new Date();
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    return `${year}-${month < 9 ? ('0'+month) : month}-${day < 9 ? ('0'+day) : day}`;
  }

  register(){

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
  if(this.animal.sterilized == null){
    this.animal.sterilized = false
  }

  this.animal.chipNumber = Number(this.animal.chipNumber)
  this.animal.photos = this.fileURLs

  console.log(this.fileURLs)
  console.log(this.animal)
  
  this.adminService.registerAnimal(this.animal).subscribe((response: any) => {
    console.log(response)

    alert('Successfully registered');

    window.location.href = '/unadopted-animals'
  },
  (error) => {
    alert("Invalid registration");
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

  readAllAnimalTypes() {

    this.animalService.allAnimalTypes().subscribe((response: any) => {
      console.log(JSON.parse(response))
  
      // @ts-ignore
      JSON.parse(response).forEach(typeObject => {
        
        this.allAnimalTypes.push(typeObject.animalType)
      });
    });
  }

  openAddNewTypeWindow(){
    this.addAnimalTypeButton = true;
  }

  addNewType(){
    console.log(this.newType)
    if(this.newType === ""){
      alert("You didn't write any new type")
    }
    else{
      this.animalTypeService.create(this.newType).subscribe((response: any) => {
        console.log(JSON.parse(response))
        alert("Successfully added new type")

        window.location.href = '/register-animal'
    
      });

    }
  }
}
