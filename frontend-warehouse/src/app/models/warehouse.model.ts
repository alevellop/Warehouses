import { Rack } from "./rack.model";

export class Warehouse {
  id: number;
  uuid: string;
  client: string;
  family: string;
  size: number;
  racks: Rack[];
}
