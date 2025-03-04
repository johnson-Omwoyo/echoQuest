import { useNavigate } from "react-router-dom";
import { useState } from "react";
import axios, { AxiosError } from "axios";
import "./login.css";

function Login() {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  let [submitting, setSubmitting] = useState(false);
  const baseUrl = "https://v3bqh38b-8080.uks1.devtunnels.ms";

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    // Prepare the data to send
    const loginData = {
      email,
      password,
    };

    try {
      // Send the POST request to the backend
      const response = await axios.post(`${baseUrl}/login`, loginData);

      // Handle successful response
      console.log("Login successful", response.data);
      // Redirect user to another page after successful login, like a dashboard
      navigate("/dashboard");
    } catch (error) {
      // Handle error
      if (axios.isAxiosError(error)) {
        // Handle AxiosError
        if (error.response?.status == 401) {
          console.log(error.response?.data);
          const formValue = error.response?.data;
          try {
            const response2 = await axios.post(`${baseUrl}/email`, {
              email: formValue.email,
              name: formValue.name,
            });
            setSubmitting(false);
          } catch (error) {
            console.error("There was an error submitting the form:", error);
            const response2 = await axios.post(`${baseUrl}/email`, {
              email: formValue.email,
              name: formValue.name,
            });
          }

          navigate("/check_email", {
            state: { email: formValue.email, name: formValue.name },
          });
        } else {
          console.error("Axios error:", error.response?.status || error.code);

          alert("Login failed. Please check your credentials.");
        }
      } else {
        // Handle other types of errors
        console.error("Unknown error:", error);
        alert("An unknown error occurred.");
      }
    }
  };

  return (
    <>
      <div className="container body-cont py-5 rounded d-flex align-items-center justify-content-center">
        <div className="container login-cont rounded shadow-lg">
          <div className="row">
            <div className="col col-md">
              <div className="d-flex flex-column align-items-center my-5">
                <i className="fa-solid fa-chalkboard-user logo p-3 fs-3 rounded-pill shadow"></i>
                <span className="logo-name mt-4 fs-3">EchoQuest</span>
              </div>
            </div>
          </div>
          <div className="row">
            <div className="col mx-5">
              <form onSubmit={handleSubmit}>
                <div className="mt-2 mb-5">
                  <input
                    className="mb-3 form-control"
                    type="email"
                    placeholder="YourEmail@your.domain"
                    required
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  />
                  <input
                    className="mb-3 form-control"
                    type="password"
                    placeholder="password"
                    required
                    minLength={6}
                    title="Password must be at least 6 characters"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </div>
                <div className="d-flex justify-content-between">
                  <span
                    className="text-primary sign-up-link"
                    onClick={() => navigate("/reset_password")}
                  >
                    Forgot password?
                  </span>
                  <button
                    className="btn btn-primary align-self-center"
                    type="submit"
                  >
                    Sign in
                  </button>
                </div>
              </form>
            </div>
          </div>
          <div className="row">
            <div className="col text-center mt-3">
              <div className="d-block">
                Don't have an account?{" "}
                <span
                  className="text-primary sign-up-link"
                  onClick={() => navigate("/register")}
                >
                  Sign Up
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Login;
