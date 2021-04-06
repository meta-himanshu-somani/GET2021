export class Vehicle {
    constructor(empVehicleDetails) {
        this.Name = empVehicleDetails.Name;
        this.Type = empVehicleDetails.Type;
        this.Number = empVehicleDetails.Number;
        this.EmpID = empVehicleDetails.EmpID;
        this.Identification = empVehicleDetails.Identification;
    }
    showDetails() {
        console.log(this.Name, this.Type, this.Number, this.EmpID, this.Identification);
    }
}
