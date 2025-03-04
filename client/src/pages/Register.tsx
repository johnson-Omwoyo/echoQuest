import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios"; // Import axios

function Register() {
  const navigate = useNavigate();
  let token = "";
  let [submitting, setSubmitting] = useState(false);
  const [regError, setRegError] = useState(false);
  const baseUrl = "http://127.0.0.1:8080";

  interface FormValue {
    [key: string]: string;
  }

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    setSubmitting(true);
    const form = e.currentTarget; // Access form element
    const formData = new FormData(form); // Create FormData from form

    let formValue: FormValue = {};

    // Iterate over the FormData and extract the form values
    formData.forEach((value, key) => {
      formValue[key] = value.toString();
    });

    // Send data to API using axios
    try {
      const response = await axios.post(`${baseUrl}/user`, formValue);

      token = response.data;

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
      // Navigate to another page or handle success response
      navigate("/check_email", { state: { email: formValue.email } });
    } catch (error) {
      console.error("There was an error submitting the form:", error);
      setRegError(true);
      setSubmitting(false);

      // Handle error response here (show error message, etc.)
    }
  };

  return (
    <>
      <div className="container body-cont py-5 rounded d-flex align-items-center justify-content-center">
        <div className="container login-cont rounded shadow-lg">
          <div className="row">
            <div className="col">
              <div className="d-flex flex-column align-items-center my-5">
                <i className="fa-solid fa-chalkboard-user logo p-3 fs-3 rounded-pill shadow"></i>
                <span className="logo-name mt-4 fs-3">EchoQuest</span>
              </div>
            </div>
          </div>
          {regError && (
            <div className="row justify-content-center">
              <div className="col-8">
                {" "}
                <div
                  className="alert alert-danger alert-dismissible fade show text-center"
                  role="alert"
                >
                  <strong>Error!</strong> User already exists.
                  <button
                    type="button"
                    className="btn-close"
                    aria-label="Close"
                    onClick={() => setRegError(false)}
                  ></button>
                </div>
              </div>
            </div>
          )}
          <div className="row">
            <div className="col mx-5">
              <form action="" onSubmit={handleSubmit}>
                <div className="mt-2 mb-5">
                  <input
                    className="mb-3 form-control"
                    type="text"
                    name="name"
                    placeholder="Full Name"
                    required
                  />
                  <input
                    className="mb-3 form-control"
                    type="email"
                    name="email"
                    placeholder="YourEmail@your.domain"
                    required
                  />
                  <input
                    className="mb-3 form-control"
                    type="password"
                    name="password"
                    placeholder="password"
                    required
                    minLength={6}
                    title="Password must be at least 6 characters"
                  />
                  <select className="form-control" name="role" required>
                    <option value="" disabled selected>
                      Select Role
                    </option>
                    <option value="interviewer">interviewer</option>
                    <option value="interviewee">interviewee</option>
                    <option value="both">interviewer & interviewee</option>
                  </select>
                </div>
                <div className="d-flex justify-content-center">
                  <button
                    className="btn btn-primary align-self-center"
                    type="submit"
                    style={{ minWidth: "128px" }}
                  >
                    {submitting ? (
                      <div className="spinner-border text-light" role="status">
                        <span className="sr-only">Loading...</span>
                      </div>
                    ) : (
                      "Sign Up"
                    )}
                  </button>
                </div>
              </form>
            </div>
          </div>
          <div className="row">
            <div className="col text-center mt-3">
              <div className="d-block">
                Already have an account{" "}
                <span
                  className="text-primary sign-up-link"
                  onClick={() => navigate("/")}
                >
                  Sign In
                </span>{" "}
              </div>
              <div className="d-flex justify-content-center gap-3">
                <span
                  className="text-primary sign-up-link"
                  onClick={() => navigate("/some")}
                >
                  About{" "}
                </span>{" "}
                <span
                  className="text-primary sign-up-link"
                  onClick={() => navigate("/some")}
                >
                  Faq's{" "}
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Register;
