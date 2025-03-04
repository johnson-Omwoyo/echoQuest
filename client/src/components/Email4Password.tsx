import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Email4Password() {
  const [submitting, setSubmitting] = useState(false);
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const baseUrl = "http://127.0.0.1:8080";
  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    setSubmitting(true);
    navigate("/");
    try {
      const response2 = await axios.post(`${baseUrl}/email/reset_password`, {
        email: email,
      });
      setSubmitting(false);
    } catch (error) {
      console.error("There was an error submitting the form:", error);
      const response2 = await axios.post(`${baseUrl}/email/reset_password`, {
        email: email,
      });
    }
  };

  return (
    <>
      <div className="container body-cont py-5 rounded d-flex align-items-center justify-content-center">
        <div className="container login-cont rounded shadow-lg">
          <div className="row">
            <div className="col">
              <div className="d-flex flex-column align-items-center my-5">
                <i className="fa-solid fa-envelope logo p-3 fs-3 rounded-pill shadow"></i>

                <span className="logo-name mt-4 fs-3">Enter your email</span>

                <p className="text-center mt-3">
                  Please enter your email to receive reset instructions
                </p>
              </div>
            </div>
          </div>
          <div className="row">
            <div className="col mx-5 d-flex justify-content-center">
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
                </div>
                <div className="d-flex justify-content-between">
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
                      "Reset Password"
                    )}
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Email4Password;
