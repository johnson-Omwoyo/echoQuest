import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";

import { Outlet } from "react-router-dom";

function App() {
  return (
    <>
      <Outlet />
    </>
  );
}

export default App;
