import './App.css';
import { useEffect, useState } from 'react';
import { BrowserRouter as Router, Routes, Route, useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
import Fraction from 'fraction.js';



const LIMIT = 3;

// function HTMLCall() {
//   const [title, setTitle] = useState('');
//   const [intro, setIntro] = useState('');
//   const [prepTime, setPrepTime] = useState('');
//   const [cookTime, setCookTime] = useState('');
//   const [serving, setServing] = useState('');
//   const [calorie, setCalorie] = useState('');
//   const [response, setResponse] = useState(null);
//   const [error, setError] = useState(null);

//   const handleSubmit = async (e) => {
//     e.preventDefault(); // Prevent form from refreshing page
//     setError(null);
//     setResponse(null);

//     try {
//       const res = await axios.post('http://localhost:8080/recipe', {
//         title,
//         intro,
//         prepTime: Number(prepTime),
//         cookTime: Number(cookTime),
//         serving: Number(serving),
//         calorie: Number(calorie),
//       });
//       setResponse(res.data); // Response data from the server
//     } catch (err) {
//       setError(err.response?.data?.message || err.message);
//     }
//   }

//   return (
//     <div>
//       <h2>Send POST Request</h2>
//       <form onSubmit={handleSubmit}>
//         <div>
//           <label>Title: </label>
//           <input
//             type="text"
//             value={title}
//             onChange={(e) => setTitle(e.target.value)}
//             required
//           />
//         </div>
//         <div>
//           <label>Intro: </label>
//           <input
//             type="text"
//             value={intro}
//             onChange={(e) => setIntro(e.target.value)}
//             required
//           />
//         </div>
//         <div>
//           <label>Prep Time: </label>
//           <input
//             type="number"
//             value={prepTime}
//             onChange={(e) => setPrepTime(e.target.value)}
//             required
//           />
//         </div>
//         <div>
//           <label>Cook Time: </label>
//           <input
//             type="number"
//             value={cookTime}
//             onChange={(e) => setCookTime(e.target.value)}
//             required
//           />
//         </div>
//         <div>
//           <label>Servings: </label>
//           <input
//             type="number"
//             value={serving}
//             onChange={(e) => setServing(e.target.value)}
//             required
//           />
//         </div>
//         <div>
//           <label>Calories: </label>
//           <input
//             type="number"
//             value={calorie}
//             onChange={(e) => setCalorie(e.target.value)}
//             required
//           />
//         </div>
//         <button type="submit">Submit</button>
//       </form>

//       {response && (
//         <div>
//           <h3>Response from Server:</h3>
//           <pre>{JSON.stringify(response, null, 2)}</pre>
//         </div>
//       )}

//       {error && <div style={{ color: 'red' }}>Error: {error}</div>}
//     </div>
//   );
  
// }

// function GetTest() {
//   const [recipes, setRecipes] = useState([]);
//   const [chosenID, setChosenID] = useState(null);


//   function displayChosen(id) {
//     setChosenID(id);
//   }
//   useEffect(() => {
//     axios.get("http://localhost:8080/recipe", {
//       params: {
//         offset: 0,
//         limit: LIMIT
//       }
//     }).then(response => {
//       setRecipes(response.data);
//     }).catch(error => {
//       console.error("Error fetching: ", error);
//     });
//   }, []);

//   return (
//     <>
//       <h2>Recipes: </h2>
//       <ul>
//         {recipes.slice(0, LIMIT).map((recipe, index) => (
//           <li key={index} onClick={() => displayChosen(recipe.id)}>Id: {recipe.id}, Title: {recipe.title}, Intro: {recipe.intro}</li>
//         ))}
//       </ul>
//       <h2>Chosen: {chosenID}</h2>
//     </>
//   );
// }

// function SearchIngTest() {
//   const [recipes, setRecipes] = useState([]);

//   useEffect(() => {
//     axios.get("http://localhost:8080/recipe/ingredient?text=onion").then(response => {
//       setRecipes(response.data);
//     }).catch(error => {
//       console.error("Error fetching: ", error);
//     });
//   }, []);
//   return (
//     <>
//       <h2>Searched Recipes: </h2>
//       <ul>
//         {recipes.slice(0, recipes.length).map((recipe, index) => (
//           <li key={index}>Id: {recipe.id}, Title: {recipe.title}, Intro: {recipe.intro}</li>
//         ))}
//       </ul>
//     </>
//   );
// } 

function Login() {
  const [error, setError] = useState(null);
  const [username, setUsername] = useState(null);
  const [password, setPassword] = useState(null);
  const handleSubmit = async (e) => {
    e.preventDefault(); // Prevent form from refreshing page

    try {
      const res = await axios.post('http://localhost:8080/login', {
        username,
        password
      }, {
        withCredentials: true
      });

    } catch (err) {
      setError(err.response?.data?.message || err.message);
      console.log(error);
    }
  }


  return (
    <>
      <h1>LOGIN</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />

      <button type="submit">Submit</button>
      </form>
    </>
  );
}

function Register() {
  const [error, setError] = useState(null);
  const [username, setUsername] = useState(null);
  const [password, setPassword] = useState(null);
  const handleSubmit = async (e) => {
    e.preventDefault(); // Prevent form from refreshing page

    try {
      const res = await axios.post('http://localhost:8080/login/register', {
        username,
        password
      }, {
        withCredentials: false
      });

    } catch (err) {
      setError(err.response?.data?.message || err.message);
      console.log(error);
    }
  }


  return (
    <>
      <h1>REGISTER</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />

      <button type="submit">Submit</button>
      </form>
    </>
  );
}

function Header() {
  const navigate = useNavigate();
  function handleHome() {
    navigate("/");
  }

  function handleLogin() {
    navigate("/login");
  }

  function handleRegister() {
    navigate("/register");
  }

  return (
    <div class="web-header">
      <button onClick={handleHome} class="home-button header-button">HOME</button>
      <h1 class="page-title">Cookbook</h1>
      <button onClick={handleRegister} class="register-button header-button">REGISTER</button>
      <button onClick={handleLogin} class="logi-button header-button">LOGIN</button>
    </div>
  );
}


function Recipe() {

  //Will eventually have userIDs which will be stored with the recipes, if userIDs match show button to take user to component to edit the recipe

  const { id } = useParams();

  const [page, setPage] = useState(null);

  useEffect(() => {
    axios.get(`http://localhost:8080/recipe/page/${id}`).then(response => {
      setPage(response.data);
    }).catch(error => {
      console.error("Error fetching: ", error);
    });

  }, [id]);
  console.log("Page: " + page);
  if(page){
    return (
      <>
        <h1>RECIPE ID: {id}</h1> 

        <RenderRecipeInfo recipe={page.recipe}/>
        <RenderRecipeIngredients ingredients={page.ingredients}/>
        <RenderRecipeDirections directions={page.directions}/>
      </>
    );
  } else {
    return <h1>Empty</h1>;
  }
}

function RenderRecipeInfo({ recipe }) {
  return (
    <div class="recipe-details">
      <h1 class="recipe-title">{recipe.title}</h1>
      <span class="recipe-intro">{recipe.intro}</span>
    </div>
  );
}

function RenderRecipeIngredients({ ingredients }) {
  

  return (
    <div class="recipe-ingredients">
      <h2>Ingredients: </h2>
      <ul>
        {ingredients.map((ingredient, index) => (
          <li key={index}>{(new Fraction(ingredient.quantity)).toFraction()} {ingredient.unit} of {ingredient.item}{ingredient.notes && `, ${ingredient.notes}`}</li>
        ))}
       </ul>
    </div>
  );
}

function RenderRecipeDirections({ directions }) {
  return (
    <div class="recipe-directions">
      <h2>Directions: </h2>
      <ol>
        {directions.map((direction, index) => (
          <li key={index}>{direction.direction}</li>
        ))}
       </ol>
    </div>
  );
}

//Offset when calling should be Limit * (N - 1) where N is current page num
function GetRecipesHome( offset, setRecipes ) {
  
  useEffect(() => {
    axios.get("http://localhost:8080/recipe", {
      params: {
        offset: offset,
        limit: LIMIT
      }
    }).then(response => {
      setRecipes(response.data);
    }).catch(error => {
      console.error("Error fetching: ", error);
    });
  }, [offset]);
}

function RenderHomeRecipes({ list }) {
  const navigate = useNavigate();
  function handleRecipeClick(id) {
    navigate(`/recipe/${id}`);
  }

  return (
    <>
      <h2>Recipes: </h2>
      <ul>
        {list.slice(0, LIMIT).map((recipe, index) => (
          <li key={index} onClick={() => handleRecipeClick(recipe.id)}>Id: {recipe.id}, Title: {recipe.title}, Intro: {recipe.intro}</li>
        ))}
       </ul>
    </>
  );
}

function PaginationHome({page, setPage, length}) {
  function handleNext() {
    setPage(page + 1);
  }

  function handlePrev() {
    setPage(page - 1);
  }


  let content;
  if(page === 1) { //No Prev Button
    content = (
      <div class="home-pagination">
        <span class="home-page-number">{page}</span>
        <button class="next-button" onClick={handleNext}>Next</button>
      </div>
    );
  } else if(length <= LIMIT) { //No Next button
    content = (
      <div class="home-pagination">
        <button class="prev-button" onClick={handlePrev}>Prev</button>  
        <span class="home-page-number">{page}</span>    
      </div>
    );
  } else { //Both buttons
    content = (
      <div class="home-pagination">
        <button class="prev-button" onClick={handlePrev}>Prev</button>  
        <span class="home-page-number">{page}</span>    
        <button class="next-button" onClick={handleNext}>Next</button>
      </div>
    );
  }

  return content;

}

function HomePage() {
  const [recipes, setRecipes] = useState([]);
  const [page, setPage] = useState(1);

  GetRecipesHome(LIMIT*(page - 1), setRecipes);
    
  return (
    <>
      <RenderHomeRecipes list={recipes}/>
      <PaginationHome page={page} setPage={setPage} length={recipes.length} />
    </>
  );
}

function App() {
  
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/" element={<HomePage />} />
        {/* <Route path="/about" element={<About />} /> */}
        <Route path="/recipe/:id" element={<Recipe />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
      </Routes>
    </Router>
  );
}

export default App;
