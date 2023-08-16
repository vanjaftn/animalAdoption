import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginUserComponent } from './modules/login-user/login-user.component';
import { RegisterUserComponent } from './modules/register-user/register-user.component';
import { UnadoptedAnimalsPageComponent } from './modules/unadopted-animals-page/unadopted-animals-page.component';
import { AdoptedAnimalsPageComponent } from './modules/adopted-animals-page/adopted-animals-page.component';
import { SubscribedAnimalsPageComponent } from './modules/subscribed-animals-page/subscribed-animals-page.component';
import { AnimalProfileComponent } from './modules/animal-profile/animal-profile.component';
import { UserProfileComponent } from './modules/user-profile/user-profile.component';

const routes: Routes = [
  { path: 'login-user', component: LoginUserComponent},
  { path: 'register-user', component: RegisterUserComponent},
  { path: 'unadopted-animals', component: UnadoptedAnimalsPageComponent},
  { path: 'adopted-animals', component: AdoptedAnimalsPageComponent},
  { path: 'subscribed-animals', component: SubscribedAnimalsPageComponent},
  { path: 'animal-profile/:id', component: AnimalProfileComponent},
  { path: 'user-profile', component: UserProfileComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
