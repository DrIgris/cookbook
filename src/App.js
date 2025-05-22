import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';

const LIMIT = 5;

function HTMLCall() {
  const [title, setTitle] = useState('');
  const [intro, setIntro] = useState('');
  const [prepTime, setPrepTime] = useState('');
  const [cookTime, setCookTime] = useState('');
  const [serving, setServing] = useState('');
  const [calorie, setCalorie] = useState('');
  const [response, setResponse] = useState(null);
  const [error, setError] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault(); // Prevent form from refreshing page
    setError(null);
    setResponse(null);

    try {
      const res = await axios.post('http://localhost:8080/cook/recipe', {
        title,
        intro,
        prepTime: Number(prepTime),
        cookTime: Number(cookTime),
        serving: Number(serving),
        calorie: Number(calorie),
      });
      setResponse(res.data); // Response data from the server
    } catch (err) {
      setError(err.response?.data?.message || err.message);
    }
  }

  return (
    <div>
      <h2>Send POST Request</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title: </label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Intro: </label>
          <input
            type="text"
            value={intro}
            onChange={(e) => setIntro(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Prep Time: </label>
          <input
            type="number"
            value={prepTime}
            onChange={(e) => setPrepTime(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Cook Time: </label>
          <input
            type="number"
            value={cookTime}
            onChange={(e) => setCookTime(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Servings: </label>
          <input
            type="number"
            value={serving}
            onChange={(e) => setServing(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Calories: </label>
          <input
            type="number"
            value={calorie}
            onChange={(e) => setCalorie(e.target.value)}
            required
          />
        </div>
        <button type="submit">Submit</button>
      </form>

      {response && (
        <div>
          <h3>Response from Server:</h3>
          <pre>{JSON.stringify(response, null, 2)}</pre>
        </div>
      )}

      {error && <div style={{ color: 'red' }}>Error: {error}</div>}
    </div>
  );
  
}

function GetTest() {
  const [recipes, setRecipes] = useState([]);
  const [chosenID, setChosenID] = useState(null);


  function displayChosen(id) {
    setChosenID(id);
  }
  useEffect(() => {
    axios.get("http://localhost:8080/cook/recipe", {
      params: {
        offset: 0,
        limit: LIMIT
      }
    }).then(response => {
      setRecipes(response.data);
    }).catch(error => {
      console.error("Error fetching: ", error);
    });
  }, []);

  return (
    <>
      <h2>Recipes: </h2>
      <ul>
        {recipes.slice(0, LIMIT).map((recipe, index) => (
          <li key={index} onClick={() => displayChosen(recipe.id)}>Id: {recipe.id}, Title: {recipe.title}, Intro: {recipe.intro}</li>
        ))}
      </ul>
      <h2>Chosen: {chosenID}</h2>
    </>
  );
}



function App() {
  
  return (
    <div className="test">
      <HTMLCall />
      <GetTest />
    </div>
  );
}

export default App;
