import { Plan } from './plan';

export class Project {
  name: string;
  startDate: Date;
  plans: Plan[];
  id: number;

  constructor(name: string, startDate: Date, plans: Plan[], id?: number) {
    this.name = name;
    this.startDate = startDate;
    this.plans = plans;
    this.id = id;
  }
}
