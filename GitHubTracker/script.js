/* 
  script.js
  Loads commits from WHATWG/HTML main branch
  and creates expandable items.
*/

const commitList = document.getElementById("commitList");
const noCommitsMsg = document.getElementById("noCommits");

async function getChangedFiles(sha) {
  const url = `https://api.github.com/repos/whatwg/html/commits/${sha}`;

  const response = await fetch(url);

  if (!response.ok) {
    throw new Error(`Failed to fetch commit details: ${response.status}`);
  }

  const commitData = await response.json();

  // GitHub returns "files" array containing all changed files
  const files = commitData.files || [];

  return files.map(f => ({
    filename: f.filename,
    status: f.status,
    additions: f.additions,
    deletions: f.deletions,
    changes: f.changes,
    patch: f.patch || ""
  }));
}


async function loadCommits() {
  try {
    const response = await fetch(
      "https://api.github.com/repos/whatwg/html/commits?sha=main"
    );

    if (!response.ok) {
      throw new Error("GitHub API error");
    }

    const commits = await response.json();

    // If empty
    if (!commits.length) {
      noCommitsMsg.textContent = "No commits found.";
      return;
    }

    noCommitsMsg.style.display = "none";

    commits.forEach(commit => {
      const li = document.createElement("li");
      li.className = "commit-item";

      const message = commit.commit.message || "No message";
      const [title, ...rest] = message.split("\n");
      const description = rest.join("\n").trim() || "No additional details";

      let titleDiv = document.createElement("div")
      titleDiv.classList.add("commit-title")
      titleDiv.innerText = title

      let descDiv = document.createElement("div")
      descDiv.classList.add("commit-details")
      descDiv.innerText = description

      li.appendChild(titleDiv)

      li.appendChild(descDiv)

      // Add expand/collapse behavior
      li.addEventListener("click", () => {
        li.classList.toggle("expanded");
      });

      commitList.appendChild(li);
    });
  } catch (err) {
    console.error(err);
    noCommitsMsg.textContent = "Failed to load commits.";
  }
}

// add a function to copy description of commit from its id 
function copyDescription(id) {
  const description = document.getElementById(id).innerText;
  navigator.clipboard.writeText(description);
}


loadCommits();
