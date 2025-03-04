import React, { useState } from "react";

function AddSessionModal({ show, handleClose, handleSave }) {
  const [sessionDetails, setSessionDetails] = useState({
    title: "",
    date: "",
    time: "",
  });

  const handleChange = (e: React.FormEvent<HTMLFormElement>) => {
    const { name, value } = e.target;
    setSessionDetails((prevDetails) => ({
      ...prevDetails,
      [name]: value,
    }));
  };

  const handleSubmit = () => {
    handleSave(sessionDetails);
    handleClose();
  };

  return (
    <div
      className={`modal ${show ? "d-block" : "d-none"}`}
      tabIndex="-1"
      role="dialog"
    >
      <div className="modal-dialog" role="document">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title">Add Mock Interview Session</h5>
            <button
              type="button"
              className="close"
              onClick={handleClose}
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div className="modal-body">
            <form>
              <div className="form-group">
                <label htmlFor="formTitle">Title</label>
                <input
                  type="text"
                  className="form-control"
                  id="formTitle"
                  name="title"
                  value={sessionDetails.title}
                  onChange={handleChange}
                  placeholder="Enter session title"
                />
              </div>
              <div className="form-group">
                <label htmlFor="formDate">Date</label>
                <input
                  type="date"
                  className="form-control"
                  id="formDate"
                  name="date"
                  value={sessionDetails.date}
                  onChange={handleChange}
                />
              </div>
              <div className="form-group">
                <label htmlFor="formTime">Time</label>
                <input
                  type="time"
                  className="form-control"
                  id="formTime"
                  name="time"
                  value={sessionDetails.time}
                  onChange={handleChange}
                />
              </div>
            </form>
          </div>
          <div className="modal-footer">
            <button
              type="button"
              className="btn btn-secondary"
              onClick={handleClose}
            >
              Close
            </button>
            <button
              type="button"
              className="btn btn-primary"
              onClick={handleSubmit}
            >
              Save Session
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default AddSessionModal;
