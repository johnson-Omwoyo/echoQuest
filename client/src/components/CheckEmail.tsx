import axios from "axios";
import { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";

function CheckEmail() {
  const navigate = useNavigate();
  const location = useLocation();
  const [verified, setVerified] = useState(false);
  const [time, setTime] = useState(3);
  let [submitting, setSubmitting] = useState(false);
  let [emailResent, setEmailResent] = useState(false);
  const baseUrl = "http://127.0.0.1:8080";

  useEffect(() => {
    const counter = () => {
      setTimeout(() => {
        setTime(time - 1);
      }, 1500);
    };
    counter();
  }, [time]);

  useEffect(() => {
    const email = location.state.email;
    console.log(email);
    const socket = new WebSocket(
      `ws://localhost:8080/ws?email=${encodeURIComponent(email)}`
    );

    socket.onmessage = (event) => {
      console.log("Received from backend:", event.data);
      const token = event.data;
      // Take action based on the received message
      localStorage.setItem("tokens", token);
      setVerified(true);
      setTimeout(() => {
        navigate("/dashboard");
      }, 1500);
    };

    return () => {
      socket.close();
    };
  }, []);
  const resendEmail = async () => {
    setSubmitting(true);
    const formValue = location.state;
    console.log(formValue);

    try {
      const response2 = await axios.post(`${baseUrl}/email`, {
        email: formValue.email,
        name: formValue.name,
      });

      window.location.reload();
    } catch (error) {
      console.error("There was an error submitting the form:", error);
      const response2 = await axios.post(`${baseUrl}/email`, {
        email: formValue.email,
        name: formValue.name,
      });
      setSubmitting(false);
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

                <span className="logo-name mt-4 fs-3">Check Your Email</span>

                <p className="text-center mt-3">
                  Please check your email {} to Verify
                </p>
              </div>
            </div>
          </div>
          <div className="row">
            <div className="col mx-5 d-flex justify-content-center">
              <button
                className="btn btn-primary align-self-center"
                type="submit"
                disabled={time > 0 || submitting}
                style={{ minWidth: "128px" }}
                onClick={async () => {
                  await resendEmail();
                }}
              >
                {verified
                  ? "Verified"
                  : time > 0
                  ? time
                  : submitting
                  ? "Resending"
                  : "Resend Email"}
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default CheckEmail;
