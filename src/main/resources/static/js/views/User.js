import createView from "../createView.js";

export default function User(props){

    return `
        <header>
        <h1>User information</h1>
        </header>
        <main>
            ${props.users.map(user => `
                <div class="container">
                <form class="row g-3">
                      <div class="col-md-6">
                        <label for="id" class="form-label">ID</label>
                        <input type="text" class="form-control" value=${user.id} data-id=${user.id}>
                      </div>
                      <div class="col-md-6">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" value=${user.username}>
                      </div>
                      <div class="col-md-6">
                        <label for="email" class="form-label">E-mail</label>
                        <input type="text" class="form-control" value=${user.email}>
                      </div>
                      <div class="col-md-6">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" value=${user.password}>
                      </div>
                      <div class="col-12">
                    <button type="button" class="edit-btn btn-primary" data-id=${user.id}>Edit</button>
                  </div>
                </form>  
                </div>
            `).join('')}
        </main>
    `;
}


export function UserEvent(){

    // $(".edit-btn").click(function () {
    //
    //     console.log("edit event fired off!!");
    //
    //     $("").attr("contenteditable", false);
    //     $(".edit-btn").text("Edit");
    //
    // })


}