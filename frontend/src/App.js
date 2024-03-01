import './App.css';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import NavigationBar from "./screen/navigation-bar";
import Message from "./admin/CreateMessage";
import CreateChild from "./component/CreateChild";
import ListParents from "./component/ListParents";
import ListChildren from "./component/ListChildren";
import Login from "./component/Login";
import HomePage from "./component/HomePage";
import Signup from "./component/Signup";
import ListFeedbacks from "./admin/ListFeedbacks";
import MessageFromAdmin from "./component/messageFromAdmin";
function App() {
    return (
        <div className="App">
            <Router>
                {/* Navigation Links */}
                <nav>
                    <Link to="/">Kindergarten  home page</Link>
                </nav>
                <Routes>
                    {/* Routes */}
                    <Route path="/screen/navigation-bar" element={<NavigationBar/>}/>
                    <Route path="/login" element={<Login style={{ marginRight: '50px' }}/>}/>
                    <Route path="/admin/Message" element={<Message/>}/>
                    <Route path="/admin/feedbacks" element={<ListFeedbacks/>}/>
                    <Route path="/" element={<HomePage/>}/>
                    <Route path="/admin/createChild" element={<CreateChild/>}/>
                    <Route path="/userslist" element={<ListParents/>}/>
                    <Route path="/components/ChildrenForEachParent" element={<ListChildren/>}/>
                    <Route path="/signUp" element={<Signup style={{ marginLeft: '50px' }}/>}/>
                    <Route path="/components/messageFromAdmin" element={<MessageFromAdmin/>}/>
                </Routes>
            </Router>
        </div>
    );
}

export default App;
