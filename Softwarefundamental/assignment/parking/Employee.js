export class Employee {
    constructor(empDetails) {
        this.name = empDetails.name;
        this.ID = empDetails.ID;
        this.gender = empDetails.gender;
        this.email = empDetails.email;
        this.password = empDetails.password;
        this.mobileNumber = empDetails.mobileNumber;
    }
    showDetails() {
        console.log(this.name, this.ID, this.gender, this.email, this.password, this.mobileNumber);
    }
}
