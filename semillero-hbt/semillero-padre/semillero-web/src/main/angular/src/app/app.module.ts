import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule  } from '@angular/forms';
import { HttpModule} from '@angular/http';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { APP_BASE_HREF } from '@angular/common';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { MenuComponent } from './semillero/componentes/menu/menu-component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { CrearPersonaComponent } from './semillero/componentes/crearPersona/crear-persona-component';
import { PrimerComponenteComponent } from './semillero/componentes/primerComponente/primer-componente-component';
import { ConsultarComicComponent } from './semillero/componentes/gestionarComic/consultarComic/consultar-comic';
import { GestionarProveedorComponent } from './semillero/componentes/gestionarProveedor/gestionar-proveedor.component';
import { ConsultarProveedorComponent } from './semillero/componentes/gestionarProveedor/consultarProveedor/consultar-proveedor.component';

// DTOs
export { ComicDTO } from './semillero/dto/comic.dto';
export { ResultadoDTO } from './semillero/dto/resultado.dto';
export { RevistaDTO } from './semillero/dto/revista.dto';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    BienvenidaComponent,
    GestionarComicComponent,
    CrearPersonaComponent,
    PrimerComponenteComponent,
    ConsultarComicComponent,
    GestionarProveedorComponent,
    ConsultarProveedorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule 
    
  ],
  providers: [
  	{ provide: APP_BASE_HREF, useValue: '/SemilleroHBT' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 

}
