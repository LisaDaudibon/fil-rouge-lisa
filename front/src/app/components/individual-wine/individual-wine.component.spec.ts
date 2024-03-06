import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndividualWineComponent } from './individual-wine.component';

describe('SwiperComponent', () => {
  let component: IndividualWineComponent;
  let fixture: ComponentFixture<IndividualWineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IndividualWineComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IndividualWineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
