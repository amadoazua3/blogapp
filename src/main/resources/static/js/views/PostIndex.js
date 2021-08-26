import createView from "../createView.js";

export default function PostIndex(props) {
    console.log(props);
    return `
    <header>
    <h1 class="text-center">Posts Page</h1>
    </header>
    <main>
        <form>
        <div class="container" >
            <input type="text" id="title" placeholder="Title">
            <input type="text" id="content" placeholder="Content">
            <select>
                <option value="">---Select a Category---</option>
                ${props.categories.map(category => `<option>${category.name}</option>`)}
            </select>
      
            <button id="create-post-btn" type="button" class="btn-primary">Add Post</button>
        </div>      
        </form>
        <div>
            ${getPostsComponent(props.posts)}
        </div>
    </main>
    `;
}

function getPostsComponent(posts){

    return posts.map(post =>
    {
        console.log(post);
        return `
          
            <div class="post">
                <div class="card-body">
                    <h3 class="edit-title" data-id=${post.id}>${post.title}</h3>
                    <p class="edit-content">${post.content}</p>
                    <h6 class="username">Posted By: ${post.user.username}</h6>
                    <button class="edit-post-btn btn-primary" data-id="${post.id}">Edit</button>
                    <button class="delete-post-btn btn-danger" data-id="${post.id}">Delete</button>
                </div>
                  
            </div>
            `}).join('');
}


function getPostCategoriesComponent(categories){

    console.log(categories);
    return categories.map(category =>
        `
            <span>#${category.name}</span>
        `
    ).join('');

}


export function PostsEvent() {

    // call function for create button listener

    createPostEvent();


    // call function for edit button listener

    editEvent();

    // call function for delete button listener

    deleteEvent();


}

function createPostEvent(){

    $("#create-post-btn").click(function () {

        let post = {
            title: $('#title').val(),
            content: $('#content').val()
        }

        let request = {
            method: "POST",
            headers: {"Content-Type":"application/json"},
            body: JSON.stringify(post)
        }

        fetch("http://localhost:8080/api/posts", request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts")
        });
    })
}

function editEvent(){

    $(".edit-post-btn").click(function () {

        console.log("edit event fired off");

        $(".edit-title, .edit-content").attr("contenteditable", false);
        $(".edit-post-btn").text("Edit");

        $(this).siblings(".edit-title, .edit-content").attr("contenteditable", true);

        $(this).text("Save");

        $(this).on("click", submitEditEvent)

    })

}


function submitEditEvent(){

    let post = {
        title: $(this).siblings(".edit-title").text(),
        content: $(this).siblings(".edit-content").text()
    }

    let request = {
        method: "PUT",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(post)
    }

    let id = $(this).attr("data-id");

    fetch(`http://localhost:8080/api/posts/${id}`, request)
        .then(res => {
            console.log(res.status);
            createView("/posts")
        }).catch(error => {
        console.log(error);
        createView("/posts")
    });

    $(this).off("click", submitEditEvent);
}


function deleteEvent(){

    $(".delete-post-btn").click(function() {

        let request = {
            method: "DELETE",
            headers: {"Content-Type":"application/json"},
        }

        let id = $(this).attr("data-id");

        fetch(`http://localhost:8080/api/posts/${id}`, request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts")
        });

    })

}