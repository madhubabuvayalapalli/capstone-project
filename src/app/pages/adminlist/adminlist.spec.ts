import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Adminlist } from './adminlist';

describe('Adminlist', () => {
  let component: Adminlist;
  let fixture: ComponentFixture<Adminlist>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Adminlist]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Adminlist);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
