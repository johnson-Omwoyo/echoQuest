import axios from "axios";
import React, { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";

function PasswordResetForm() {
  const [newPassword, setNewPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const location = useLocation();
  const navigate = useNavigate();
  const searchParams = new URLSearchParams(location.search);
  const baseUrl = "https://v3bqh38b-8080.uks1.devtunnels.ms";

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    // Add your form submission logic here
    console.log("New Password:", newPassword);
    console.log("Confirm Password:", confirmPassword);
    if (newPassword === confirmPassword) {
      try {
        console.log(searchParams.get("email"));
        const response = await axios.post(`${baseUrl}/reset_password`, {
          password: newPassword,
          email: searchParams.get("email"),
        });

        alert("Password reset succesfully");
        navigate("/");
      } catch (error: any) {
        console.log(error.status);
        alert("Request not allowed.Request for the reset link again");
        setTimeout(() => {
          navigate("/reset_password");
        }, 1500);
      }
    } else {
      alert("Passwords do not match");
    }
  };

  return (
    <div style={styles.container}>
      <h1 style={styles.title}>Reset Your Password</h1>
      <form onSubmit={handleSubmit}>
        <div style={styles.formGroup}>
          <label htmlFor="new-password" style={styles.label}>
            New Password:
          </label>
          <input
            type="password"
            id="new-password"
            name="new-password"
            value={newPassword}
            onChange={(e) => setNewPassword(e.target.value)}
            required
            style={styles.input}
          />
        </div>
        <div style={styles.formGroup}>
          <label htmlFor="confirm-password" style={styles.label}>
            Confirm Password:
          </label>
          <input
            type="password"
            id="confirm-password"
            name="confirm-password"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            required
            style={styles.input}
          />
        </div>
        <button
          type="submit"
          style={{
            backgroundColor: "#1e73be",
            color: "white",
            padding: "12px 20px",
            textDecoration: "none",
            borderRadius: "4px",
            display: "inline-block",
            marginTop: "20px",
            textAlign: "center",
            border: "none",
            cursor: "pointer",
          }}
        >
          Reset Password
        </button>
      </form>
    </div>
  );
}

const styles = {
  container: {
    backgroundColor: "#fff",
    padding: "20px",
    margin: "50px auto",
    width: "80%",
    maxWidth: "600px",
    borderRadius: "8px",
    boxShadow: "0 2px 10px rgba(0, 0, 0, 0.1)",
  },
  title: {
    color: "#1e73be",
  },
  formGroup: {
    marginBottom: "15px",
  },
  label: {
    display: "block",
    marginBottom: "5px",
  },
  button: {
    backgroundColor: "#1e73be",
    color: "white",
    padding: "12px 20px",
    textDecoration: "none",
    borderRadius: "4px",
    display: "inline-block",
    marginTop: "20px",
    textAlign: "center",
    border: "none",
    cursor: "pointer",
  },
  input: {
    width: "100%",
    padding: "8px",
    border: "1px solid #ccc",
    borderRadius: "4px",
  },
};

export default PasswordResetForm;
