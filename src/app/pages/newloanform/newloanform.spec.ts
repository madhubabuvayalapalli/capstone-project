import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Newloanform } from './newloanform';

describe('Newloanform', () => {
  let component: Newloanform;
  let fixture: ComponentFixture<Newloanform>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Newloanform]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Newloanform);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
