export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
<!--    MAKE CREATE FORM HERE    -->
            <div class="post-container">
                <form>
                <input type="text" placeholder="Enter text">
                <button onclick="PostEvents" id="btn-add">Add</button>
                ${props.posts.map(post => `
                    <h3 class="post-title" data-id=${post.id}>${post.title}</h3>
                    <h2>${post.content}</h2>
                    <!--   add edit, delete buttons, add edit form   -->
                    <button onclick="PostEvents" id="btn-edit">Edit</button>
                    <button onclick="PostEvents" id="btn-delete">Delete</button>
                                        `).join('')}   
              
                </form>
            </div>
    
                
                    
        </main>
    `;
}

export function PostsEvent() {

    // call function for create button listener

    var addListener = function (event){

        const value = document.querySelector('input').value;
        console.log(value);
    }

    document.getElementById('btn-add').addEventListener('click', addListener);

    // call function for edit button listener

    var editListener = function (event){

    }

    document.getElementById('btn-edit').addEventListener('click', editListener);

    // call function for delete button listener

    var deleteListener = function (event){

    }

    document.getElementById('btn-delete').addEventListener('click', deleteListener);

}