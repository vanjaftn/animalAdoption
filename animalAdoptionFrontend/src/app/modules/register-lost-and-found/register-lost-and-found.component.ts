import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { PhotoService } from '../service/photo.service';
import { AnimalWithPhotosDTO } from '../model/animal-with-photos-DTO.model';
import { AnimalTypeService } from '../service/animalType.service';
import { LostAndFoundService } from '../service/lostAndFound.service';

@Component({
  selector: 'app-register-lost-and-found',
  templateUrl: './register-lost-and-found.component.html',
  styleUrls: ['./register-lost-and-found.component.css']
})
export class RegisterLostAndFoundComponent {
  public animal : AnimalWithPhotosDTO = new AnimalWithPhotosDTO();
  public selectedFile!: File;
  public selectedFiles: Array<File> = new Array()
  public fileURLs : Array<string> = new Array()
  public allAnimalTypes : Array<String> = new Array()
  public addAnimalTypeButton: Boolean = false
  public newType: string = ""
  public isAnimalLostOrFound : string = ""

  constructor(private lostAndFoundService: LostAndFoundService, private photoService: PhotoService, private animalService: AnimalService,
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

    if(this.isInputValid()){

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
      this.animal.photos = this.fileURLs

      console.log(this.fileURLs)
      console.log(this.animal)
      console.log(this.isAnimalLostOrFound)
      
      if(this.isAnimalLostOrFound === "Lost"){
        this.lostAndFoundService.registerLost(this.animal).subscribe((response: any) => {
            console.log(response)
      
            alert('Successfully registered');
      
            // window.location.href = '/unadopted-animals'
          },
          (error) => {
            alert("Invalid registration");
            console.log(error);
          });
      }
      else if(this.isAnimalLostOrFound === "Found"){
        this.lostAndFoundService.registerFound(this.animal).subscribe((response: any) => {
          console.log(response)
    
          alert('Successfully registered');
    
          // window.location.href = '/unadopted-animals'
        },
        (error) => {
          alert("Invalid registration");
          console.log(error);
        });
      }
      else{
        alert("Invalid registration");
      }
      }
    

  }

  
  public isInputValid(): boolean {

    if (this.animal.name.trim() == '' || this.animal.animalType.trim() == '' || this.animal.description.trim() == '' || 
    this.animal.gender.trim() == '' || this.animal.location.trim() == '' || this.animal.size.trim() == '' || 
    this.isAnimalLostOrFound.trim() == '') {
        alert('Please fill in all fields!');
        return false;
     }

     return true;
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
