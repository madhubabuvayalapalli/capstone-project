import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Registerc } from './registerc';

describe('Registerc', () => {
  let component: Registerc;
  let fixture: ComponentFixture<Registerc>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Registerc]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Registerc);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
