import App from "./App";
import CheckEmail from "./components/CheckEmail";
import Email4Password from "./components/Email4Password";
import PasswordResetForm from "./components/PasswordResetForm";
import Login from "./pages/Login";
import Register from "./pages/Register";
import UserDashboard from "./pages/UserDashboard";

const routes = [
  {
    path: "/",
    element: <App />,
    errorElement: "Error Occured",
    children: [
      { path: "/", element: <Login /> },
      { path: "/register", element: <Register /> },
      { path: "/check_email", element: <CheckEmail /> },
      { path: "/dashboard", element: <UserDashboard /> },
      { path: "reset_password", element: <Email4Password /> },
      { path: "/reset_form", element: <PasswordResetForm /> },
    ],
  },
];

export default routes;
