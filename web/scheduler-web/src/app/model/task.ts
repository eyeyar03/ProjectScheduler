export class Task {
  name: string;
  guiId: number;
  duration: number;
  dependsOn: string;

  constructor(name: string, guiId: number, duration: number) {
    this.name = name;
    this.guiId = guiId;
    this.duration = duration;
  }
}
