import { Task } from './task';

export class Plan {
  name: string;
  id: number;
  tasks: Task[];

  constructor(name: string, id: number, tasks: Task[]) {
    this.name = name;
    this.id = id;
    this.tasks = tasks;
  }
}
