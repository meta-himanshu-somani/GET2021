export class Vehicle{
    Name:string;
    Type:string;
    Number:string;
    EmpID:string;
    Identification:string;
    constructor(empVehicleDetails: {Name:string,Type:string,Number:string,
        EmpID:string,Identification:string}) {
        this.Name = empVehicleDetails.Name;
        this.Type = empVehicleDetails.Type;
        this.Number =empVehicleDetails.Number;
        this.EmpID =empVehicleDetails.EmpID;
        this.Identification =empVehicleDetails.Identification;
    }
    showDetails(){
        console.log(this.Name,this.Type,this.Number,this.EmpID,this.Identification);
    }
}