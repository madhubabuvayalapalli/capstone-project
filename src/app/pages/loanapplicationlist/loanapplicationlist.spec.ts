import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Loanapplicationlist } from './loanapplicationlist';

describe('Loanapplicationlist', () => {
  let component: Loanapplicationlist;
  let fixture: ComponentFixture<Loanapplicationlist>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Loanapplicationlist]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Loanapplicationlist);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
